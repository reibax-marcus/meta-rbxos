FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:prepend = "\
    file://syslog.cfg               \
    file://busybox-syslog.default   \    
    file://syslog.conf              \
    file://crond.service            \
    "

inherit systemd

PACKAGES += " ${PN}-crond "
SYSTEMD_PACKAGES += " ${PN}-crond "
# Cannot be enabled until #302 is solved
# SYSTEMD_SERVICE:${PN}-crond = " crond.service "

SRC_URI += "file://cron.cfg"

do_install:append() {
    install -d  ${D}/${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/crond.service ${D}${systemd_system_unitdir}
}

FILES:${PN}-crond = " \
        ${sbindir}/crond \
        ${systemd_system_unitdir}/crond.service \
        "
