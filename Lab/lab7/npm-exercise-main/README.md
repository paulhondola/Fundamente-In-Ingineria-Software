# NPM Exercise

`npm` is a package manager for JavaScript projects. It is the default package manager for the JavaScript runtime environment Node.js. 
It consists of a command line client, also called npm, and an online database of public and paid-for private packages, 
called the npm registry. The registry is accessed via the client, and the available packages can be browsed and searched via the npm website.

### Installation
To install npm, you can download it from the [npm website](https://www.npmjs.com/get-npm). 
You can also install it using a package manager like [Homebrew](https://brew.sh/) on macOS or [Chocolatey](https://chocolatey.org/) on Windows.
However we recommend installing npm using `NVM` (Node Version Manager), which is a bash script to manage multiple active Node.js versions.
To install Node and NPM using nvm on Linux, run the following command in your terminal:
```
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.2/install.sh | bash
```
This command will install nvm. To test if nvm is installed correctly, run `nvm --version` in **a new terminal instance**. You should see something like this:
```
0.39.0
```
To install Node and NPM using nvm, run the following command in your terminal:
```
nvm install 22
```
This command will install Node and NPM. To test if Node and NPM are installed correctly, run `node -v` and `npm -v` in your terminal. You should see something like this:
```
v22.*.*

10.9.2
```

## Exercise

Please follow the instructions to get started with the NPM Exercise. In this exercise we will build a NodeJS CLI application
that prints greets the user in different languages and outputs the text in different colors.
We will display use Gradle to build the application, manage resources and manage dependencies.


### 1. Initialize the npm project
This command This will create a package.json file and prompt you to enter some information about your project. 
You can use the default values or customize them as needed.
For example, for License, you can choose between the following options: `ISC`, `MIT`, `Apache-2.0`.
No scripts are needed for this project, so you can leave the default value for `entry point` and `test command`.
```shell
npm init
```

### 2. Install the dependencies
To install the dependencies, run the following command in your terminal:
```shell
npm install chalk
```
This command will install the `chalk` package and add it to the `package.json` file. The `package.json` file will look like this:
```json
{
  "name": "hello-npm",
  "version": "1.0.0",
  ...
  "dependencies": {
    "chalk": "^5.0.0"
  }
}
```
The project will look like this:
```
hello-npm
├── package-lock.json
├── package.json
└── node_modules
```
The `package.json` file is the manifest of the project. The `package-lock.json` file is the lockfile of the project. 
The `node_modules` directory contains the dependencies of the project.

If you inspect the `package-lock.json` file, you will see that the `chalk` package has brought in a lot of other dependencies.
You can see all the dependencies in the `node_modules` directory.

### 3. Hello World
Create a new file called `index.js` in the `hello-npm` directory. 
The `index.js` file will have the following content:
```js
console.log("Hello World!");
```

### 4. Run the application
Run the following command in your terminal:
```shell
node index.js
```
You should see the following output:
```
Hello World!
```
To add a script that will run the application, add the following line to the `scripts` section in the `package.json` file:
```json
{
    ...
    "scripts": {
        "start": "node index.js"
    }
}
```
Run the following command in your terminal:
```shell
npm start
```
This should run your project. You should see the following output:
```
Hello World!
```

### 5. Hello World with Chalk
To use the `chalk` package, add the following line to the `index.js` file:
```js
import chalk from 'chalk';
```
To use the `chalk` package, add the following line to the `index.js` file:
```js
console.log(chalk.blue('Hello world!'));
```

Make the node application a module by adding the following line to the `package.json` file:
```json
{
    ...
    "type": "module"
}
```

Run the following command in your terminal:
```shell
npm start
```
This should run your project. You should see the following output (in blue):
```
Hello World!
```

### 6. Internationalization
Create a new folder called assets to store your JSON files.
```shell
mkdir assets
```
Create a JSON file for each language you want to support, containing the greeting, person greeted, punctuation, and color for each field.
For example, assets/en.json for English, assets/es.json for Spanish, assets/de.json for German, and assets/ro.json for Romanian.

`assets/en.json`
```json
{
  "greeting": {
    "text": "Hello",
    "color": "whiteBright"
  },
  "person": {
    "text": "Friends",
    "color": "blue"
  },
  "punctuation": {
    "text": "!",
    "color": "red"
  }
}
```
`assets/es.json`
```json
{
  "greeting": {
    "text": "Hola",
    "color": "red"
  },
  "person": {
    "text": "Amigos",
    "color": "yellow"
  },
  "punctuation": {
    "text": "!",
    "color": "red"
  }
}
```
`assets/de.json`
```json
{
  "greeting": {
    "text": "Hallo",
    "color": "black"
  },
  "person": {
    "text": "Freunde",
    "color": "red"
  },
  "punctuation": {
    "text": "!",
    "color": "yellow"
  }
}
```
`assets/ro.json`
```json
{
  "greeting": {
    "text": "Salut",
    "color": "blue"
  },
  "person": {
    "text": "Prieteni",
    "color": "yellow"
  },
  "punctuation": {
    "text": "!",
    "color": "red"
  }
}
```

### 7. Read the JSON files and print the greeting
To read the JSON files, add the following line to the `index.js` file:
```js
import { readFileSync } from 'fs';
import path from 'path';
import chalk from 'chalk';

import { fileURLToPath } from 'url';
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

function printGreeting(language) {
    console.log(chalk[language.greeting.color](language.greeting.text),
        chalk[language.person.color](language.person.text),
        chalk[language.punctuation.color](language.punctuation.text));
}

const args = process.argv.slice(2);

let lang = 'en';
if (args.length > 0) {
    lang = args[0];
}

const languageFile = path.join(__dirname, 'assets', `${lang}.json`);
const languageData = readFileSync(languageFile, 'utf8');
const language = JSON.parse(languageData);

printGreeting(language);
```

### 8. Run the application
Run the following command in your terminal, with all language options:
```shell
npm start es
```
Verify that the output is correct for each language.

### 9. Make the application executable
To make the application executable, add the following line as the first line to the `index.js` file:
```js
#!/usr/bin/env node
```
Add a new property to your `package.json` file called bin that specifies the name of the executable file you want to create.
```json
{
    ...
    "bin": {
        "hello-npm": "index.js"
    }
}
```

Install the package globally:
```shell
npm install -g
```
Run the following command in your terminal, with all language options:
```shell
hello-npm es
```
Verify that the output is correct for each language.
