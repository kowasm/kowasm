import { instantiate } from "./build/compileSync/wasm/main/productionExecutable/kotlin/kowasm-web-server-sample-wasm.uninstantiated.mjs";
import { WASI } from "wasi";

export const wasi = new WASI({
    args: ["argument1", "argument2"],
    env: {
        "PATH" : "/usr/local/bin:/usr/bin",
        "HOME": "/home/seb"
    },
    preopens: {
        '/sandbox': process.cwd() + '/build/'
    }
});

const { exports, instance } = await instantiate({ wasi_snapshot_preview1 : wasi.wasiImport }, false);
wasi.initialize(instance);

exports.__init()