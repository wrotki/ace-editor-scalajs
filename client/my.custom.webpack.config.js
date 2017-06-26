var webpack = require('webpack');

module.exports = require('./scalajs.webpack.config');

// And then modify `module.exports` to extend the configuration
//module.exports.plugins = (module.exports.plugins || []).concat([
//  new UglifyJsPlugin({ sourceMap: module.exports.devtool === 'source-map' })
//]);

