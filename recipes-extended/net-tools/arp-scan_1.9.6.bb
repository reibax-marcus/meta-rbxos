DESCRIPTION = "The ARP scanner"
HOMEPAGE = "http://www.nta-monitor.com/tools-resources/security-tools/arp-scan"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r1"

DEPENDS = "libpcap"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "https://github.com/royhills/arp-scan/archive/${PV}.tar.gz "

SRC_URI[md5sum] = "18de9fcba8aeca986dc892b7f7e6bfc7"
SRC_URI[sha256sum] = "971b45c3369816467994797fbcd0076eb8f0ffb9c42764ea6dba25ab3fd490da"

inherit autotools

