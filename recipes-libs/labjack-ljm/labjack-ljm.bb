# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

PV = "1.20.0"
LJLIBFNAMEPREFIX = "LabJackM-1.2000-openSUSE-Linux-aarch64"
LJLIBFNAME = "${LJLIBFNAMEPREFIX}-release.tar.gz"
LJLDIR = "${LJLIBFNAMEPREFIX}"

SRC_URI = "https://labjack.com/sites/default/files/software/${LJLIBFNAME}"
SRC_URI[md5sum] = "033954299d53b05362feae05094c7624"
SRC_URI[sha256sum] = "48b0a74c26d4399c44745108894765b2ba0593084394fbdf1a6d812564746c8c"

S = "${WORKDIR}"
B = "${S}/LabJackM"

DEPENDS = "libusb1"
RDEPENDS:${PN} = "libusb1"

do_compile () {
    mkdir -p "${B}"
    ${S}/${LJLDIR}/LabJackM.run --noexec --nox11 --keep --target "${B}"
}

INSANE_SKIP:${PN} += "already-stripped"

do_install () {
    install -d 0755 "${D}${libdir}"
    install -d 0755 "${D}${includedir}"
    install -d 0755 "${D}/usr/local/share/LabJack/LJM"
    install -m 0644 "${B}/libLabJackM.so.${PV}" "${D}${libdir}"
    ln -sf "libLabJackM.so.${PV}" "${D}${libdir}/libLabJackM.so.1"
    ln -sf "libLabJackM.so.1" "${D}${libdir}/libLabJackM.so"
    install -m 0644 "${B}/LabJackM.h" "${D}${includedir}"
    install -m 0644 "${B}/LabJack/LJM/ljm_constants.json" "${D}/usr/local/share/LabJack/LJM/"
}

FILES:${PN} += " /usr/local/share/LabJack/LJM/ljm_constants.json /usr/lib/*.so"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"

RPROVIDES:${PN} += " libLabJackM.so()(64bit) libLabJackM.so(LJM_1)(64bit) "
RPROVIDES:${PN}-dev += " libLabJackM.so()(64bit) libLabJackM.so(LJM_1)(64bit) "
