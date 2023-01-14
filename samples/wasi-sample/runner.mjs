import { instantiate } from "./build/compileSync/wasm/main/productionExecutable/kotlin/kowasm-wasi-sample-wasm.uninstantiated.mjs";
import { WASI } from "wasi";

export const wasi = new WASI();

const { exports, instance } = await instantiate({ wasi_snapshot_preview1 : wasi.wasiImport });
wasi.initialize(instance);
