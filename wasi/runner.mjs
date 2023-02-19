import { instantiate } from "./build/compileSync/wasm/test/testProductionExecutable/kotlin/kowasm-wasi-wasm-test.uninstantiated.mjs";
import { WASI } from "wasi";

export const wasi = new WASI({
    args: ["argument1", "argument2"],
    preopens: {
        '/sandbox': process.cwd() + '/build/'
    }
});

const { exports, instance } = await instantiate({ wasi_snapshot_preview1 : wasi.wasiImport });
wasi.initialize(instance);

exports.startUnitTests();
