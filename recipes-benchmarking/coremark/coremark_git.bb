# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE.md
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0a18b17ae63deaa8a595035f668aebe1"

SRC_URI = "git://github.com/eembc/coremark.git;protocol=https;nobranch=1"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "1541482bf3e6ef7f5c69f5be76b14537b60833d0"

S = "${WORKDIR}/git"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
    # Make sure your .conf machine configuration file specifies the MACHINE_THREADS variable
    export MACHINE_THREADS=${MACHINE_THREADS}
	# You will almost certainly need to add additional arguments here
	oe_runmake LFLAGS_END="-pthread" XCFLAGS="-DMULTITHREAD=${MACHINE_THREADS} -DUSE_PTHREAD" PORT_DIR=linux compile
}

do_install () {
    install -d "${D}${bindir}"
    install -m 0755 "${B}/coremark.exe" "${D}${bindir}/coremark"
}

INSANE_SKIP:${PN} = "ldflags"
