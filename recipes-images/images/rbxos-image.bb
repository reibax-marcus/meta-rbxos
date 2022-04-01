SUMMARY = "rbxos image"
DESCRIPTION = "Base image with no rbxos specific software for select hw systems"

LICENSE = "CLOSED"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_FSTYPES += " squashfs squashfs.aes "

# You can use this section to force the system
# to build certain elements first
DEPENDS = "\
          "

IMAGE_INSTALL = "\
    rbxos-versionfile                   \
    packagegroup-core-boot              \
    ${CORE_IMAGE_EXTRA_INSTALL}         \
    packagegroup-systemtools            \
    packagegroup-swupdate               \
    kernel-modules                      \
    run-postinsts                       \
               "

# It might be important for this inherit
# to happen before core-image
inherit rbxos-image-version
inherit core-image
inherit extrausers
inherit conversion_type_aescrypt
inherit postprocess-rbxos

# set image passwords
ROOT_PASSWORD ?= "root"

# Calculate password hash and add users in system
EXTRA_USERS_PARAMS = "\
   usermod -p `openssl passwd ${ROOT_PASSWORD}` root; \
   "

ROOTFS_POSTPROCESS_COMMAND += "add_used_packages_to_build_image_to_image; "
ROOTFS_POSTPROCESS_COMMAND += "add_opkg_sample_debug_source_configfile; "
POPULATE_SDK_POST_TARGET_COMMAND:append = " remove_private_keys; "
