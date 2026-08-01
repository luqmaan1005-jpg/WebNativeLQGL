export function isAndroidWebView(): boolean {

    const ua = navigator.userAgent || "";

    return (
        /Android/i.test(ua) &&
        /wv/i.test(ua)
    );
}
