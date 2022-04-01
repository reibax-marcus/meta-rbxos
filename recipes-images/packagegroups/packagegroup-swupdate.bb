DESCRIPTION = "SWUpdate basic required packages"

LICENSE = "CLOSED"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} =    "\
    u-boot-fw-utils  \
    swupdate         \
    swupdate-www     \
                    "
