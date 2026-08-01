export function getBridge() {
    if (!window.AndroidGoogle) {
        throw new Error("WebNativeLQGL native Android bridge not installed");
    }
    return window.AndroidGoogle;
}
