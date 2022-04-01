IMAGE_TYPES += " \
                squashfs.aes \
                "

CONVERSIONTYPES += " aes "

# You might want to tweak these variables in your image recipe file
CONVERSION_AES_KEYPROVIDER ?= "upgrade-keys"
CONVERSION_AES_SYMCRIPTKEY ?= "${RECIPE_SYSROOT}${datadir}/upgrade-keys/aes256_symmetric.crypt"
CONVERSION_AES_PRIVKEY ?= "${RECIPE_SYSROOT}${datadir}/upgrade-keys/priv.pem"
CONVERSION_AES_PASSFILE ?= "${RECIPE_SYSROOT}${datadir}/upgrade-keys/.swupdate_priv_pwd"

oe_conversion_type_aes() {
    type="$1"

    # Get decrypted symmetric key
    eval $(openssl rsautl -decrypt -in ${CONVERSION_AES_SYMCRIPTKEY} -inkey ${CONVERSION_AES_PRIVKEY} \
            -passin file:${CONVERSION_AES_PASSFILE} | sed 's/\ //g')

    # Verify that the variables have been set
    [ -z ${key} ] && { echo "key variable not found" ; exit 2 ; }
    [ -z ${salt} ] && { echo "salt variable not found" ; exit 2 ; }
    [ -z ${iv} ] && { echo "iv variable not found" ; exit 2 ; }

    # encrypt image
    openssl enc -aes-256-cbc -in ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${type} -out ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${type}.aes -K ${key} -iv ${iv} -S ${salt}
}

CONVERSION_CMD:aes = "oe_conversion_type_aes ${type}"
CONVERSION_DEPENDS_aes = "openssl-native ${CONVERSION_AES_KEYPROVIDER}"
