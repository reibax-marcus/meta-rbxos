SUMMARY = "Ramdisk to prepare boot with all properly mounted"
DESCRIPTION = "Contents all need packages to mount root using squashfs and overlayfs before pivoting to real root"

LICENSE = "CLOSED"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

IMAGE_FSTYPES:append = " cpio.gz.u-boot cpio.gz.u-boot.version"

IMAGE_INSTALL = "\
    ${VIRTUAL-RUNTIME_base-utils}       \
    udev                                \
    base-passwd                         \
    ${ROOTFS_BOOTSTRAP_INSTALL}         \
    mmc-utils                           \
    mtd-utils                           \
    e2fsprogs                           \
    dosfstools                          \
    ramdisk-init                        \
    u-boot-fw-utils                     \
    "

inherit core-image
inherit conversion_type_version
