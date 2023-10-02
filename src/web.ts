import { WebPlugin } from '@capacitor/core';

import type { InstallRefererPlugin } from './definitions';

export class InstallRefererWeb extends WebPlugin implements InstallRefererPlugin {
  async getReferrer(): Promise<any> {
    //console.log('GetReferrer', options);
    return Promise.resolve("Not Implemented");
  }
}
