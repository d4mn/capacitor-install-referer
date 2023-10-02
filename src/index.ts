import { registerPlugin } from '@capacitor/core';

import type { InstallRefererPlugin } from './definitions';

const InstallReferer = registerPlugin<InstallRefererPlugin>('InstallReferer', {
  web: () => import('./web').then(m => new m.InstallRefererWeb()),
});

export * from './definitions';
export { InstallReferer };
