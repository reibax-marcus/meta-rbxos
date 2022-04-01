LICENSE="CLOSED"
DESCRIPTION="Dummy package to force image recompilation when image git describe changes"
inherit rbxos-sw-version allarch

do_install[nostamp]="1"

do_install() {
    install -d ${D}${sysconfdir}
    echo "${RBXOS_SW_VERSION}" > "${D}${sysconfdir}/build.rbxosversion"
    chmod 644 "${D}${sysconfdir}/build.rbxosversion"
}

