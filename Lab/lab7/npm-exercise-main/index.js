#!/usr/bin/env node

import { readFileSync } from "fs";
import path from "path";
import chalk from "chalk";

import { fileURLToPath } from "url";
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

function printGreeting(language) {
	console.log(
		chalk[language.greeting.color](language.greeting.text),
		chalk[language.person.color](language.person.text),
		chalk[language.punctuation.color](language.punctuation.text),
	);
}

const args = process.argv.slice(2);

let lang = "en";
if (args.length > 0) {
	lang = args[0];
}

const languageFile = path.join(__dirname, "assets", `${lang}.json`);
const languageData = readFileSync(languageFile, "utf8");
const language = JSON.parse(languageData);

printGreeting(language);
