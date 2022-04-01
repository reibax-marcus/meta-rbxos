DESCRIPTION = "Generic system tools that we want in our system"

LICENSE = "CLOSED"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    rbxos-bashrc  \
    lsof          \
    less          \
    mmc-utils     \
    mtd-utils     \
    e2fsprogs     \
    dosfstools    \
    tzdata        \
    rsync         \
    systemtools   \
                 "
