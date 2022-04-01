DESCRIPTION = "RAMdisk Init file"
LICENSE = "CLOSED"

RDEPENDS:${PN} += " busybox util-linux-fdisk"

SRC_URI = "file://init  \
           "

S = "${WORKDIR}"

inherit allarch

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0755 ${S}/init ${D}/
    ln -sfT /proc/mounts "${D}${sysconfdir}/mtab"
}

FILES:${PN} = "\
    /init      \
    ${sysconfdir}/mtab \
    "
