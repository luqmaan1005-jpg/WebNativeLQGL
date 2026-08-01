export interface AndroidGoogleBridge {
    signIn(callback: string): void;
    signOut(): void;
}
declare global {
    interface Window {
        AndroidGoogle?: AndroidGoogleBridge;
    }
}
export declare function getBridge(): AndroidGoogleBridge;
