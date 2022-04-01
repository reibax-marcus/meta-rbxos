FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:prepend = "file://watchdog.conf \
                   file://watchdog.default"
