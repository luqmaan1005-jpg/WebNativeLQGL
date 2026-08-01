import { signIn } from "./signIn";
import { signOut } from "./signOut";
import { isAndroidWebView } from "./detectWebView";
export const WebNativeLQGL = {
    signIn,
    signOut,
    supported() {
        return isAndroidWebView();
    }
};
