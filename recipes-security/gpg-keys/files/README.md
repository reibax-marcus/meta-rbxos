# Key policy

Key files here have been published in a public repo. A secret key should always be kept secret. This is done this way for demo purposes.

You should generate your own key pairs if you want your system to be secure.

You can add them by adding append files in your own layer that override files here on the same recipe.

This is how you can generate new key pair files:

```
# Generate gpg key pair
# Do not add a keyphrase
gpg --gen-key
# Export the key pair to individual files
gpg --export sample@address > rbxos.open.gpg.pubk
gpg --export-secret-keys sample@address > rbxos.open.gpg.privk
# List the keys from your local keyring
gpg --list-keys
# Extract the key hash and use it to delete the key pair from your keyring
gpg --delete-secret-and-public-keys 53A7CAECCBCC57A006F803FAB6E914F5FC4A6D85
```
