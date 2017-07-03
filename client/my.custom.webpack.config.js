var webpack = require('webpack');

module.exports = require('./scalajs.webpack.config');

//  "entry": {
//    "client-fastopt": "/Users/mariusz/concurix/goworkspace/src/github.com/wrotki/scalajs-spa-starter/client/target/scala-2.11/scalajs-bundler/main/fastopt-launcher.js"
//  },

// And then modify `module.exports` to extend the configuration
//module.exports.plugins = (module.exports.plugins || []).concat([
//  new UglifyJsPlugin({ sourceMap: module.exports.devtool === 'source-map' })
//]);

