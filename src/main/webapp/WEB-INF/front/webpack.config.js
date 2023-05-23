// //webpack.config.js与index.html同级
//
// const path = require('path');
// const HtmlWebpackPlugin = require('html-webpack-plugin')
// const webpack = require('webpack');
// //需要使用包  npm init生成package.json文件
//
// module.exports = {
//   entry: './src/main.js', //入口
//   output: {
//     path: path.resolve(__dirname, 'dist'), //动态获取路径,需要使用包path,   __dirname node中的全局变量
//     filename: 'bundle.js',
//     publicPath: 'dist/'//任何涉及url的都会自动加上dist/
//   }, //出口
//   module:{
//     rules:[
//       {
//         test: /\.vue$/,
//         loader: 'vue-loader'
//       },
//       {
//         test: /\.css$/,
//         use: [ 'style-loader','css-loader']
//       },
//       {
//         test: /\.js$/,
//         //exclude排除
//         //include包含
//         exclude: /node_modules/,
//         use: {
//           loader: 'babel-loader',
//           options: {
//             presets: ['es2015']
//           }
//         }
//       }
//       ]
//   },
// }
//
