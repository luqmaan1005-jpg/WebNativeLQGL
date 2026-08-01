import { getBridge } from "./bridge";
import { GoogleUser, SignInOptions } from "./types";


export function signIn(
    options: SignInOptions
): Promise<GoogleUser> {

    return new Promise((resolve, reject)=>{

        const bridge = getBridge();


        const callbackName =
            "WebNativeLQGLCallback";


        (window as any)[callbackName] =
            (result:any)=>{

                delete (window as any)[callbackName];


                if(result.error){
                    reject(
                        new Error(result.error)
                    );
                    return;
                }


                resolve(result);
            };


        bridge.signIn(
            callbackName
        );

    });
}
