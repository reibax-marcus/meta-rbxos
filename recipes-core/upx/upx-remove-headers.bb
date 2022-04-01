DESCRIPTION = "C script to remove headers after upx pack"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://upx-remove-headers.c "

INSANE_SKIP:${PN} = "ldflags"
INSANE_SKIP:${PN}-dev = "ldflags"
S="${WORKDIR}"

do_compile () {
         ${CC} ${WORKDIR}/upx-remove-headers.c -o ${WORKDIR}/upx-remove-headers
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${B}/upx-remove-headers ${D}${bindir}/upx-remove-headers
}

BBCLASSEXTEND= "native"
