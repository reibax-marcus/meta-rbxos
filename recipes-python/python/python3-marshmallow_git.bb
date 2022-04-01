# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "A lightweight library for converting complex datatypes to and from native Python datatypes."
HOMEPAGE = "https://github.com/marshmallow-code/marshmallow"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   docs/license.rst
# NOTE: Original package / source metadata indicates license is: MIT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5bccd400dedfa74364481e56aacc0b4a \
                   "

SRC_URI = "git://github.com/marshmallow-code/marshmallow;protocol=https;branch=dev"

# Modify these as desired
PV = "3.14.1"
SRCREV = "${PV}"

S = "${WORKDIR}/git"

inherit setuptools3

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-datetime python3-io python3-math python3-netclient python3-numbers python3-pytest python3-pytz python3-simplejson"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    marshmallow
#    marshmallow.error_store
#    marshmallow.exceptions
#    marshmallow.validate
