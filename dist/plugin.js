var capacitorInstallReferer = (function (exports, core) {
    'use strict';

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

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
