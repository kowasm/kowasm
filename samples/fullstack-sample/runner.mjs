import { instantiate } from "./server/build/compileSync/wasm/main/productionExecutable/kotlin/kowasm-server-wasm.uninstantiated.mjs";
import { WASI } from "wasi";

export const wasi = new WASI({
    preopens: {
        '/sandbox': process.cwd() + '/client/build'
    }
});

const { exports, instance } = await instantiate({ wasi_snapshot_preview1 : wasi.wasiImport }, false);
wasi.initialize(instance);

exports.__init()