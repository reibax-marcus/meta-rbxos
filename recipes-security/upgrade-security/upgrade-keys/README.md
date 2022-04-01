# RSA PKCS#1.5
RSA Public / private key. The private key belongs to thebuildsystem, while the public key must be installed on the target.
This is properly integrated in yocto and swupdate scripts contained here.

Passphrases for these keys should be stored in the rbxos central password encrypted database. Ask authorized personel at rbxos if you need access.

## Generating private and public key
First, the private key must be created:

```
$ openssl genrsa -aes256 -out priv.pem
```

This asks for a passphrase.

The private key is used to export the public key with:

```
$ openssl rsa -in priv.pem -out public.pem -outform PEM -pubout
```

## Generating symmetric key to encrypt update images
Generate original file:
```
$ openssl enc -aes-256-cbc -k $(cat .swupdate_priv_pwd) -P -md sha1 2>/dev/null > aes256_symmetric.key
$ echo $(eval $(cat aes256_symmetric.key | sed 's/ //g') ; echo "$key $iv $salt" ;) > aes256.key

```

Encrypt this file to upload to git repository:
```
$ openssl rsautl -encrypt -inkey public.pem -in aes256_symmetric.key -pubin -out aes256_symmetric.crypt
```

## References
More details in swupdate documentation:
* [https://sbabic.github.io/swupdate/signed_images.html](Update images from verified source)
* [https://sbabic.github.io/swupdate/encrypted_images.html](Encryoted images)
