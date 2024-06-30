import { instantiate } from "./build/compileSync/wasmJs/main/productionExecutable/kotlin/kowasm-samples-web-server-sample-wasm-js.uninstantiated.mjs";
import { WASI } from "wasi";

export const wasi = new WASI({
    version: 'preview1',
    args: ["argument1", "argument2"],
    env: {
        "PATH" : "/usr/local/bin:/usr/bin",
        "HOME": "/home/seb"
    },
    preopens: {
        '/sandbox': process.cwd() + '/build/'
    }
});

import * as net from "net";
import * as http from "http";
const { exports, instance } = await instantiate({ wasi_snapshot_preview1 : wasi.wasiImport, net, http }, false);
wasi.initialize(instance);
