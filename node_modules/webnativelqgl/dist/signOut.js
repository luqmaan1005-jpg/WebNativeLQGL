import { getBridge } from "./bridge";
export function signOut() {
    const bridge = getBridge();
    bridge.signOut();
}
