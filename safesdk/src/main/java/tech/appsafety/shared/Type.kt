package tech.appsafety.shared

import androidx.annotation.Keep

@Keep
enum class Type {
    VPN,
    MIRRORING,
    ROOT,
    EMULATOR,
    SAFETYNET,
    MULTIPLE_APP_INSTANCE,
    VIRTUAL_CONTAINER,
    MULTI_USERS,
    TAMPERED_PACKAGE,
    MOCK_LOCATION
}
