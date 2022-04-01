VERSION_FILENAME ?= "${PF}"
VERSION_BASENAME ?= "${IMAGE_BASENAME}"

do_deploy:append() {
    VFN="${VERSION_FILENAME}"
    VBN="${VERSION_BASENAME}"
    if [ ! -z ${KERNEL_ARTIFACT_NAME} ] ; then
        VFN="${KERNEL_IMAGETYPE}-${KERNEL_ARTIFACT_NAME}"
        VBN="${KERNEL_IMAGETYPE}-${KERNEL_ARTIFACT_LINK_NAME}"
    fi
    cd "${DEPLOYDIR}" || exit 2
    echo "version=${EXTENDPKGV}" > "${VFN}.version"
    VVF=$(find . -type f -name "${VFN}*" -not -name '*.version')
    if [ -z ${VVF} ] ; then echo "ERROR: No version verifiable files found." ; exit 2 ; fi
    for file in $VVF ; do
        sha256sum "$(basename "${file}")"  >> "${VFN}.version"
    done
    # Work around Yocto honister not setting VBN for u-boot
    if [ -z "${VBN}" ] ; then
        export VBN="${UBOOT_BINARYNAME}-${PACKAGE_ARCH}"
    fi
    ln -sfT "${VFN}.version" "${DEPLOYDIR}/${VBN}.version"
}

