# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "A Flask extension adding a decorator for CORS support"
HOMEPAGE = "https://github.com/corydolphin/flask-cors"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=118fecaa576ab51c1520f95e98db61ce"

SRC_URI = "git://github.com/corydolphin/flask-cors;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "24c45cef84a160207057c7c0735fc5fb08143420"

S = "${WORKDIR}/git"

inherit setuptools3

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-datetime python3-flask python3-logging python3-netclient python3-werkzeug"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    collections.abc
#    six
#    urllib.parse


