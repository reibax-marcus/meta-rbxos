# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Flask + marshmallow for beautiful APIs"
HOMEPAGE = "https://github.com/marshmallow-code/flask-marshmallow"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   docs/license.rst
#   docs/_themes/LICENSE
# NOTE: Original package / source metadata indicates license is: MIT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c3ff8567ef1f2a8cf223f30ac5a6f094 \
                    file://docs/_themes/LICENSE;md5=da1f8f97f9ee64ad7466c3c531ad2c5b"

SRC_URI = "git://github.com/marshmallow-code/flask-marshmallow.git;protocol=https;nobranch=1"

# Modify these as desired
PV = "0.14.0+git${SRCPV}"
SRCREV = "d79d4641fda0db9a4d256cc500ceabbf0c186743"

S = "${WORKDIR}/git"

inherit setuptools3

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-distutils python3-flask python3-json python3-werkzeug"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    flask_marshmallow
#    flask_marshmallow.fields
#    flask_marshmallow.sqla
#    flask_sqlalchemy
#    marshmallow
#    marshmallow_sqlalchemy
#    pytest


