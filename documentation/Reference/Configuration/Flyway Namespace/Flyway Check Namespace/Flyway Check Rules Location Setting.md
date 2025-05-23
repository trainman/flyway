---
subtitle: flyway.check.rulesLocation
---

{% include enterprise.html %}

{% include commandlineonly.html %}

## Description

It is possible to change where Flyway looks for rules (for example if you keep them separately under configuration management) and this is done by setting the
`rulesLocation` parameter.

Be aware that this is will be the only place Flyway looks for rules so if you want to use the Redgate supplied ones then you'll need to copy them from the /rules folder to the new location.

__Note:__ Flyway will only look in the default or specified locations for rules and won't traverse sub-folders.

See [Code Analysis](https://documentation.red-gate.com/flyway/flyway-concepts/code-analysis) for more information.

## Type

String

## Default

By default, the rules are located in the /rules folder of your Flyway installation path

## Usage

### Flyway Desktop

This can't be set in a config file via Flyway Desktop, although it will be honoured, and it can be configured as an advanced parameter in operations on the Migrations page.

### Command-line

```powershell
./flyway check -code -check.rulesLocation=/my_rules_folder
```

### TOML Configuration File

```toml
[flyway.check]
rulesLocation = "/my_rules_folder"
```

### Configuration File

```properties
flyway.check.rulesLocation=/my_rules_folder
```
