SUMMARY = "FOCAS library to access FANUC machines"
SECTION = "libs"
LICENSE = "CLOSED"

SRC_URI = "file://fwlib32.h  \
           file://libfwlib32.so.1.0.5"

S = "${WORKDIR}"

INSANE_SKIP:${PN} += "arch"
INSANE_SKIP:${PN} += "file-rdeps"

do_install () {
        install -m 0755 -d ${D}${libdir}
        oe_soinstall ${S}/libfwlib32.so.1.0.5 ${D}${libdir}
        install -d ${D}${includedir}
        install -m 0755 ${S}/*.h ${D}${includedir}
}
