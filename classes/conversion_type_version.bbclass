CONVERSIONTYPES += " version "

inherit siteinfo kernel-arch image-artifact-names

oe_conversion_type_version() {
    echo "version=${EXTENDPKGV}" > ${IMAGE_NAME}.version
    versiontype=""
    for searchtype in ${IMAGE_FSTYPES} ; do
        if echo $searchtype | grep -q "\.version$" ; then
            versiontype="${searchtype}"
        fi
    done
    if [ ! -z "${versiontype}" ] ; then
        versiontype="$(echo ${versiontype} | sed 's/\.version//g')"
    else
        echo "ERROR: Could not find version type extension in IMAGE_FSTYPES ${IMAGE_FSTYPES}" >&2
        exit 1
    fi
    sha256sum ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${versiontype} >> ${IMAGE_NAME}.version
    ln -sfT "${IMAGE_NAME}.version" "${IMAGE_LINK_NAME}.version"
}

CONVERSION_CMD:version = "oe_conversion_type_version"

