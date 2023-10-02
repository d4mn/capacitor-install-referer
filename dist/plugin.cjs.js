'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const InstallReferer = core.registerPlugin('InstallReferer', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.InstallRefererWeb()),
});

class InstallRefererWeb extends core.WebPlugin {
    async getReferrer() {
        //console.log('GetReferrer', options);
        return Promise.resolve("Not Implemented");
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    InstallRefererWeb: InstallRefererWeb
});

exports.InstallReferer = InstallReferer;
//# sourceMappingURL=plugin.cjs.js.map
