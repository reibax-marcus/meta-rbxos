inherit rbxos-sw-version

# This is the logical way of getting our desired filenames
# but whatever we do we always end up with taskhash errors
#IMAGE_VERSION_SUFFIX = "-${RBXOS_SW_VERSION}"
#IMAGE_VERSION_SUFFIX[vardepsexclude] += "RBXOS_SW_VERSION"
# This is an incredibly hacky alternative way to get away
# with our desired file name. It will someday explode in our
# faces, but it seems to work for now.
# (The default value of IMAGE_VERSION_SUFFIX is "${DATETIME}")
DATETIME = "${RBXOS_SW_VERSION}"
IMAGE_BUILDINFO_VARS += " RBXOS_SW_VERSION "

