import { WebPlugin } from '@capacitor/core';
import type { InstallRefererPlugin } from './definitions';
export declare class InstallRefererWeb extends WebPlugin implements InstallRefererPlugin {
    getReferrer(): Promise<any>;
}
