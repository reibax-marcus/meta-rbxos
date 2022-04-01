add_used_packages_to_build_image_to_image() {
    cp ${DEPLOY_DIR}/licenses/${IMAGE_NAME}/license.manifest ${IMAGE_ROOTFS}/etc/
}

add_opkg_sample_debug_source_configfile() {
    cat << EOF >> ${IMAGE_ROOTFS}/etc/opkg/srcdebug.conf.example
# This is a template file to easily configure new package sources
# It's goal is to make life easier for developers that want to install
# new packages to a debug unit
# Tips to use this file:
# 1. In your development pc, open a console and navigate to your yocto
#    build directory/tmp/deploy
# 2. Open a simple http server there: python -m SimpleHTTPServer
# 3. In you overonX unit, copy this file and remove the .example suffix
# 4. Edit with vi and replace every SRCDBG with your development machine ip address:
#    :s/SRCDBG/192.168.8.99/g
src/gz debug_all http://SRCDBG:8000/all
src/gz debug:aarch64 http://SRCDBG:8000/aarch64
EOF
}

remove_private_keys() {
    rm -fr "${SDK_OUTPUT}${SDKTARGETSYSROOT}${datadir}/upgrade-keys"
}
