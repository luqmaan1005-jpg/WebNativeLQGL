export interface AndroidGoogleBridge {
    signIn(
        callback: string
    ): void;

    signOut(): void;
}


declare global {
    interface Window {
        AndroidGoogle?: AndroidGoogleBridge;
    }
}


export function getBridge() {

    if (!window.AndroidGoogle) {
        throw new Error(
            "WebNativeLQGL native Android bridge not installed"
        );
    }

    return window.AndroidGoogle;
}
