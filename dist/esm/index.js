import { registerPlugin } from '@capacitor/core';
const InstallReferer = registerPlugin('InstallReferer', {
    web: () => import('./web').then(m => new m.InstallRefererWeb()),
});
export * from './definitions';
export { InstallReferer };
//# sourceMappingURL=index.js.map