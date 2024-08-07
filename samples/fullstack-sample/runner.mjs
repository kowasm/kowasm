import { instantiate } from "./server/build/compileSync/wasmJs/main/productionExecutable/kotlin/kowasm-samples-fullstack-sample-server-wasm-js.uninstantiated.mjs";
import { WASI } from "wasi";

export const wasi = new WASI({
    version: 'preview1',
    preopens: {
        '/sandbox': process.cwd() + '/client/build'
    }
});

import * as net from "net";
import * as http from "http";
const { exports, instance } = await instantiate({ wasi_snapshot_preview1 : wasi.wasiImport, net, http }, false);
wasi.initialize(instance);
