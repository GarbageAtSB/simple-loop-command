# Simple Loop Command
This is a simple plugin that adds a command that loops other commands a certain amount of times with a specific delay. Inspired by the version of this command that Hypixel staff use, visible in [this video]((https://www.youtube.com/watch?v=1ltqQbKX7js)) by the former admin Minikloon. It should also be noted that the commands can be ran not just by players, but by any command executor, including the console and command blocks.

Developed for 1.21.11, tested succesfully in 26.1. It should probably work in most modern versions because of its simplicity, but I can't be arsed testing them all.




# COMMANDS
/loop <amount> [<delay (ticks)>] <command> - Loops the specified command the denoted amount of times with the stated delay between executions, in ticks. If the delay is not included (i.e. the second argument is not a number but rather the start of the command), it defaults to 1 tick.
/stoploop - Stops the currently running loop. The loop will also be cancelled if the player leaves and rejoins the server.




# PERMISSIONS
loop.use - Allows the use of both commands.




# DOWNLOAD
You can download this plugin through the SpigotMC website or from the Releases tab
