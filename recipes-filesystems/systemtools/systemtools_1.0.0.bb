DESCRIPTION = "System tools for rbxos"
LICENSE = "CLOSED"

inherit allarch
inherit systemd

SYSTEMD_SERVICE:${PN} = " reboot-watchdog-fallback.service "

SRC_URI = "\
    file://factory_reset \
    file://reboot-watchdog-fallback \
    file://reboot-watchdog-fallback.service \
    "

S = "${WORKDIR}"

RDEPENDS:${PN} += "bash watchdog-manager"

do_install() {
    install -d ${D}/${bindir}/
    install -m 0755 ${S}/factory_reset ${D}/${bindir}/
    install -m 0755 ${S}/reboot-watchdog-fallback ${D}/${bindir}/
    install -d ${D}/${systemd_system_unitdir}
    install -m 0644 ${S}/reboot-watchdog-fallback.service ${D}/${systemd_system_unitdir}
}

FILES:${PN} += "${systemd_system_unitdir}"
