import { getBridge } from "./bridge";
export function signIn(options) {
    return new Promise((resolve, reject) => {
        const bridge = getBridge();
        const callbackName = "WebNativeLQGLCallback";
        window[callbackName] =
            (result) => {
                delete window[callbackName];
                if (result.error) {
                    reject(new Error(result.error));
                    return;
                }
                resolve(result);
            };
        bridge.signIn(callbackName);
    });
}
