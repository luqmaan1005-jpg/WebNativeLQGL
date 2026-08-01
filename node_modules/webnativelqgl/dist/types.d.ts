export interface GoogleUser {
    id: string;
    name: string;
    email: string;
    photo?: string;
    idToken: string;
}
export interface SignInOptions {
    serverClientId: string;
}
