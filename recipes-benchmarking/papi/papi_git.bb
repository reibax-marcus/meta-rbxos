# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Performance Application Programming Interface"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE.txt
#   src/libpfm4/COPYING
#   src/libpfm4/debian/copyright
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "CLOSED"

DEPENDS = "libgfortran gcc-runtime"
RDEPENDS:${PN} = "libgomp python3-core python3-shell"

SRC_URI = "git://bitbucket.org/icl/papi.git;protocol=https"

# Modify these as desired
PV = "6.0.0.1+git${SRCPV}"
SRCREV = "65833547f68ca3f52535c672e768b7f70427a44a"

S = "${WORKDIR}/git/src"

EXTRA_OECONF:append = "\
     --with-ffsll \
     --with-tls=__thread \
     --with-walltimer=gettimeofday \
     --with-virtualtimer=clock_thread_cputime_id \
     --with-OS=linux \
     --with-arch=aarch64 \
     --with-CPU=arm \
     --with-tests=no \
     "

# TODO: really fix this QA checks
INSANE_SKIP:${PN} = "useless-rpaths file-rdeps"

# NOTE: spec file indicates the license may be "BSD"
inherit autotools-brokensep

do_configure:prepend() {
     export F77=$FC
}

do_compile:prepend() {
    export FFLAGS="$(echo $FC | cut -d' ' -f2-)"
}

do_install:append() {
    chown -R root:root ${D}/
}
